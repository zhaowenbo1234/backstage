简单后台管理系统 

1.  技术

   - springboot 2.0.6
   - druid-boot 1.1.10
   - mybatis-boot 1.3.2
   - mysql 5.1.44
   - ~~tk.mapper 4.1.0(使用的话，sql可以少些很多，放弃使用，学习些sql)~~

2. 功能

   > 1. 简单权限功能（暂时先做这个，其余后续补充）

3.  在mapper 中添加注解 `@Repository`，不加的话会在 idea 中使用`@Autowired`会抛红，不影响运行，强迫症决定加上

4.在控制台打印 sql ，将 mapper 所在的包的日志级别设置为 debug 即可。 
使用zTree  jQuery 版本冲突，先暂时写死，后期寻找好的插件。
