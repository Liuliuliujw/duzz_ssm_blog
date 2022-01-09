package com.liu.ssmblog.mapper;

import com.liu.ssmblog.entity.*;
import com.liu.ssmblog.enums.UserRoles;
import com.liu.ssmblog.enums.UserStatus;
import com.liu.ssmblog.enums.VisibleStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: llliujw
 * @Description: 测试数据访问层的部分方法
 */ 
@RunWith(SpringRunner.class)
@ContextConfiguration("/spring-mybatis.xml")
public class MapperTest {
    
    @Autowired
    UserMapper userMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleTagRefMapper articleTagRefMapper;

    @Autowired
    ArticleCategoryRefMapper articleCategoryRefMapper;

    @Autowired
    CommentMapper commentMapper;
    
    String TestUserName = "";

    /**
     * 测试插入
     */
    @Test
    public void testAllInsert(){
        testInsertUser();
        testInsertTagAndCategory();
        testInsertArticle();
        testInsertComment();
    }

    /**
     * 删除测试产生的数据
     */
    @Test
    public void testDeleteByAllInsert(){
        //获得测试时插入的用户的id
        Optional<User> user = userMapper.listUser().stream().filter(s -> s.getUserName().equals(TestUserName)).findFirst();
        Integer userId = user.get().getUserId();
        //获取测试用户的所有文章
        List<Integer> articleIds = articleMapper.listArticleIdsByUserId(userId);
        //删除测试用户文章与标签和分类的关联，以及文章的评论
        articleIds.forEach( articleId ->{
            articleTagRefMapper.deleteArticleTagRefByArticleId(articleId);
            articleCategoryRefMapper.deleteArticleCategoryRefByArticleId(articleId);
            commentMapper.deleteCommentByArticleId(articleId);
        });
        //删除测试用户的文章
        articleMapper.deleteArticleBatchByIds(articleIds);
        //删除测试标签
        tagMapper.listTag().stream().filter(s -> s.getTagName().startsWith("TestTag"))
                .forEach( tag -> tagMapper.deleteTagById(tag.getTagId()));
        //删除测试分类
        categoryMapper.listCategory().stream().filter(s -> s.getCategoryName().startsWith("TestCategory"))
                .forEach( category -> categoryMapper.deleteCategoryById(category.getCategoryId()));
        //删除测试用户
        userMapper.deleteUserById(userId);
    }

    public void testInsertUser() {
        Date now = new Date();
        User user = new User();
        user.setUserName(TestUserName);
        user.setUserPass("123123123");
        user.setUserNickname("11111111");
        user.setUserEmail("123@163.com");
        user.setUserAvatar("/test/1");
        user.setUserRegisterTime(now);
        user.setUserLastLoginTime(now);
        user.setUserStatus(UserStatus.NORMAL.getValue());
        user.setUserRole(UserRoles.USER.getValue());
        userMapper.insertUser(user);
    }

    public void testInsertTagAndCategory() {
        Tag tag1 = new Tag();
        tag1.setTagName("TestTag");
        tag1.setTagDescription("测试标签");
        Tag tag2 = new Tag();
        tag2.setTagName("TestTag2");
        tag2.setTagDescription("测试标签2");
        Tag tag3 = new Tag();
        tag3.setTagName("TestTag3");
        tag3.setTagDescription("测试标签3");
        tagMapper.insertTag(tag1);
        tagMapper.insertTag(tag2);
        tagMapper.insertTag(tag3);

        Category category = new Category();
        category.setCategoryName("TestCategory");
        category.setCategoryDescription("测试分类");
        Category category2 = new Category();
        category2.setCategoryName("TestCategory2");
        category2.setCategoryDescription("测试分类2");
        categoryMapper.insertCategory(category);
        categoryMapper.insertCategory(category2);
    }

    public void testInsertArticle() {
        //获得测试时插入的用户的id
        Optional<User> user = userMapper.listUser().stream().filter(s -> s.getUserName().equals(TestUserName)).findFirst();
        Integer userId = user.get().getUserId();

        Date now = new Date();
        Article article = new Article();
        article.setArticleUserId(userId);
        article.setArticleTitle("测试文章");
        article.setArticleSummary("文章测试");
        article.setArticleThumbnail("/file/test");
        article.setArticleContent("<h1>文章测试测试测试测试测试</h1>");
        article.setArticleViewCount(2);
        article.setArticleCommentCount(2);
        article.setArticleLikeCount(2);
        article.setArticleStatus(VisibleStatus.NORMAL.getValue());
        article.setArticleCreateTime(now);
        article.setArticleUpdateTime(now);
        articleMapper.insertArticle(article);

        Integer articleId = articleMapper.listArticleIdsByUserId(userId).get(0);

        //获得测试时测试标签的id集合
        List<Integer> testTagIds = tagMapper.listTag().stream()
                .filter(s -> s.getTagName().startsWith("TestTag")).map(s -> s.getTagId()).collect(Collectors.toList());
        //获得测试时测试分类的id集合
        List<Integer> testCategoryIds = categoryMapper.listCategory().stream()
                .filter(s -> s.getCategoryName().startsWith("TestCategory")).map(s -> s.getCategoryId()).collect(Collectors.toList());

        //添加文章的标签
        testTagIds.forEach(tagId -> {
            ArticleTagRef articleTagRef = new ArticleTagRef();
            articleTagRef.setArticleId(articleId);
            articleTagRef.setTagId(tagId);
            articleTagRefMapper.insertArticleTagRefMapper(articleTagRef);
        });

        //添加文章的分类
        testCategoryIds.forEach(categoryId -> {
            ArticleCategoryRef articleCategoryRef = new ArticleCategoryRef();
            articleCategoryRef.setArticleId(articleId);
            articleCategoryRef.setCategoryId(categoryId);
            articleCategoryRefMapper.insertArticleCategoryRef(articleCategoryRef);
        });
    }

    public void testInsertComment(){
        //获得测试时插入的用户的id
        Optional<User> user = userMapper.listUser().stream().filter(s -> s.getUserName().equals(TestUserName)).findFirst();
        Integer userId = user.get().getUserId();
        //获取测试用户的文章ID
        Integer articleId = articleMapper.listArticleIdsByUserId(userId).get(0);
        //获取时间
        Date now = new Date();

        Comment comment = new Comment();
        comment.setCommentArticleId(articleId);
        comment.setCommentUserId(userId);
        comment.setCommentCreateTime(now);
        comment.setCommentContent("测试评论");

        commentMapper.insertComment(comment);
    }
}
