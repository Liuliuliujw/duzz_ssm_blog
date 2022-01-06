# duzz_ssm_blog

# 项目简介

一个基于SSM的轻量个人博客网站，运用的主要技术栈有SpringMVC、Spring、Mybatis、Thymeleaf、Bootstrap。该项目功能技术简单，结构完整，技术栈版本较新，没有过多的依赖，适合快速上手SSM练习
，推荐使用IDEA开发。

# 项目运行环境

- JDK 11
- MySQL 8.0.27
- Tomcat 9.0.56
- Maven 3.8.4

# 数据库设计

| 表名                  | 描述 |
|----------------------|:--|
| article              | 文章 |
| article_category_ref | 文章分类关联 |
| article_tag_ref      | 文章标签关联 |
| category             | 分类 |
| comment              | 评论 |
| custom_page          | 自定义页面 |
| link                 | 友链 |
| menu                 | 菜单 |
| site_option          | 网页配置 |
| tag                  | 标签 |
| user                 | 用户 |



