Spring Boot + Spring Cache + Spring Data JPA + Gradle + Swagger2 + RESTful + MySQL

一、创建名为cache的数据库

二、如果entity包中报错，请下载Lombok插件，然后重启IDEA

三、本项目是Spring Boot 的 Spring缓存抽象的个人练习项目

    1)Spring缓存抽象主要核心是：
        1、CacheManager : 缓存管理器，管理各种缓存(Cache)组件
        2、Cache : 缓存接口，定义缓存的操作，实现有：ConcurrentMapCahe(本项目采用)、RedisCache、EnCacheCache等
    
    2)主要的注解：
        1、@EnanbleCaching : 开启基于注解的缓存
        2、@Cacheable : 声明可缓存
        3、@CachePut : 更新缓存(既调用目标方法，也更新缓存))
        4、@CacheEvict : 清空缓存
        5、@Caching : 定义复杂的缓存规则(是一个组合注解包含@Cacheable、@CachePut、@CacheEvict)
        6、@CacheConfig : 抽取公共的缓存属性

    3)原理:
        1、自动配置类(CacheAutoConfiguration)去选择出缓存的自动配置类(有11个)
        2、默认生效 SimpleCacheConfiguration 配置类，SimpleCacheConfiguration给容器注册一个CacheManager(ConcurrentMapManager)
        3、CacheManager(ConcurrentMapManager)获取和创建Cache(ConcurrentMapCahe)类型的缓存组件，作用是将数据保存在ConcurrentMap中

    4)@Cacheable的运行过程
        1、先查询Cache(缓存组件),是按照CacheNames指定的名字获取Cache(CacheManager先获取相应的缓存)
        2、若没有查询出Cache，那么创建出一个Cache
        3、使用key(默认是方法的参数值),去查询Cache的内容
        4、若没有查询到缓存，那么会调用目标方法，然后将目标方法到返回值放进Cache(缓存)中

        ps:默认的key是按照SimpleKeyGenerator策略生成的
            1、无参数，key = new SimpleKey();
            2、1个参数，key = param(参数值);
            3、多个参数，key = new SimpleKey(params);

        ps:总结:
            在@Cacheable注解标注的方法执行之前先检查缓存中有无这个数据，默认按照参数的值作为key去查询缓存，若无则运行目标方法并将结果放入缓存，之后在再次调用就可以直接使用缓存中的数据。
    