关于 `spring.jpa.hibernate.ddl-auto`：

![](https://i.imgur.com/TkmJ0UA.png)

![](https://i.imgur.com/V1uEjyH.png)

关于 `spring.jpa.show-sql`：

![](https://i.imgur.com/h08D7GG.png)

关于 `@Entity` 注解：

<https://www.cnblogs.com/hoojjack/p/6568920.html>

优先级：@Table > @Entity。


`lombok` 常用注解：

<https://www.jianshu.com/p/7e29098dc1a5>

JPA `@Id` 注解：

设置属性为主键。

<https://www.cnblogs.com/mark5/p/10929137.html>

`@Table(name = "tbl_student")` 注解：

明确指明将类映射成表的表名。

`@Column(name = "email_address")`：

列名。

hibenate 注解：

<https://blog.css8.cn/post/1586622.html>

```java
@SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
```

@SequenceGenerator — 注解声明了一个数据库序列

属性：
- name - 表示该表主键生成策略名称，它被引用在@GeneratedValue中设置的“gernerator”值中
- sequenceName - 表示生成策略用到的数据库序列名称(不太理解)
- initialValue - 表示主键初始值，默认为0
- allocationSize - 每次主键值增加的大小，例如设置成1，则表示每次创建新记录后自动加1，默认为50

@GeneratedValue(strategy = GenerationType , generator="") - 可选，用于定义主键生成策略

属性：
- strategy - 表示主键生成策略，取值有：
- GenerationType.AUTO 根据底层数据库自动选择（默认），若数据库支持自动增长类型，则为自动增长
- GenerationType.INDENTITY 根据数据库的Identity字段生成，支持DB2、MySQL、MS、SQL Server、SyBase与HyperanoicSQL数据库的Identity类型主键
- GenerationType.SEQUENCE 使用Sequence来决定主键的取值，适合Oracle、DB2等支持Sequence的数据库，一般结合@SequenceGenerator使用（Oracle没有自动增长类型，只能用Sequence）
- GenerationType.TABLE  使用指定表来决定主键取值，结合@TableGenerator使用
- generator - 表示主键生成器的名称，这个属性通常和ORM框架相关 , 例如：Hibernate 可以指定 uuid 等主键生成方式

uniqueConstraints 用来批量命名唯一键 
其作用等同于多个：@Column(unique = true)
其 `name` 属性不太了解。

---

@Repository用于标注数据访问组件，即DAO组件。

@SpringBootTest注解是SpringBoot自1.4.0版本开始引入的一个用于测试的注解。

@DataJpaTest用于测试 JPA 信息库。 与@RunWith(SpringRunner.class)结合使用。 注解会禁用完全自动配置，并且仅应用与 JPA 测试相关的配置。 默认情况下，带有@DataJpaTest注解的测试使用嵌入式内存数据库。

@Embeddable：

将一个实体类内置在另一个实体类中，但是不在数据库中生成这个类的表。

@Builder 注解：

通过@Builder注解，lombok可以方便的使用建造者模式。

@Query("select s from Student s where s.emailId = ?1")

用来写类似于 SQL 的语句。

如果数据库操作是修改数据而非查询数据，则需要再额外使用 @Modifying 注解提示 JPA 该操作是修改操作。

@OneToOne
@JoinColumn(name = "course_id", referencedColumnName = "courseId")

一对一关系。

@OneToOne(cascade = CascadeType.ALL)

- CascadeType.PERSIST：级联新增（又称级联保存）：对A对象保存时也会对B对象进行保存。并且，只有A类新增时，会级联B对象新增。若B对象在数据库存在则抛异常。对应EntityManager的presist方法。
- CascadeType.MERGE：级联合并（级联更新）：指A类新增或者变化，会级联B对象（新增或者变化）。对应EntityManager的merge方法。
- CascadeType.REMOVE：级联删除：只有A类删除时，会级联删除B类,即在设置的那一端进行删除时，另一端才会级联删除。对应EntityManager的remove方法。
- CascadeType.REFRESH：级联刷新：获取A对象时也重新获取最新的B对象。对EntityManager的refresh(object)方法。即会重新查询数据库里的最新数据（用的比较少）
- CascadeType.DETACH：级联分离。
- CascadeType.ALL：级联所有操作。

很多刚学的同学对懒加载和立即加载的理解还是模棱两可。

这里给出我的个人理解：

1、FetchType.LAZY：懒加载，加载一个实体时，定义懒加载的属性不会马上从数据库中加载。

2、FetchType.EAGER：急加载，加载一个实体时，定义急加载的属性会立即从数据库中加载。

3、比方User类有两个属性，name跟address，就像百度知道，登录后用户名是需要显示出来的，此属性用到的几率极大，要马上到数据库查，用急加载；而用户地址大多数情况下不需要显示出来，只有在查看用户资料是才需要显示，需要用了才查数据库，用懒加载就好了。所以，并不是一登录就把用户的所有资料都加载到对象中，于是有了这两种加载模式。

关于 mappedBy：

规律：凡是双向关联，mappedBy必设，因为根本都没必要在2个表中都存在一个外键关联，在数据库中只要定义一边就可以了

a) 只有OneToOne,OneToMany,ManyToMany上才有mappedBy属性，ManyToOne不存在该属性； 

b) mappedBy标签一定是定义在the owned side(被拥有方的)，他指向the owning side(拥有方)；

c) mappedBy的含义，应该理解为，拥有方能够自动维护 跟被拥有方的关系； 

- targetEntity 关联目标实体类，指定类型后该属性可省略；
- cascade表示关联关系中的级联操作权限，有五种权限：
    - CascadeType.PERSIST：级联新增（又称级联保存）；
    - CascadeType.MERGE：级联合并，更新该实体时，与其有映射关系的实体也跟随更新；
    - CascadeType.REMOVE：级联删除，删除该实体时，与其有映射关系的实体也跟随删除；
    - CascadeType.REFRESH：级联刷新，该实体被操作前都会刷新，保证数据合法性；
    - CascadeType.ALL：包含以上四种级联操作；
- fetch数据加载策略，默认值为FetchType.EAGER：
    - FetchType.LAZY 表示数据获取方式为懒加载；
    - FetchType.EAGER 表示数据获取方式为急加载；
- optional 表示关联关系是否必须，当该值为true时，one的一方可以为null；
- mappedBy 指定映射关系由哪一方维护，一般使用在双向映射场景；
- orphanRemoval 孤值删除，将会删除孤立数据，外键为null的数据将被删除；