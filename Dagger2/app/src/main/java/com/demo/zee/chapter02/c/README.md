### 使用作用域遵循的一些规则

1. 尽量使用默认作用域
2. 使用作用域注解的模块，管理的对象要么是默认作用域，要么和组件相同的作用域
3. 作用域的指定，下层要么不指定，如果指定的话必须和上层一致。
    @Component为第三层，最上层
    @Module为第二层，中间层
    @Inject/@Provides/@Binds为一层，最底层

4. 开发时需要有清晰的依赖关系图，否则容易循环依赖


