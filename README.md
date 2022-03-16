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