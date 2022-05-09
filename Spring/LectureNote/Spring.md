## 📃 docs에 api 보기 (in local)

```
C:/00.KOSMO108/90.Download/spring/spring-framework-3.2.9.RELEASE/docs/javadoc-api/index.html
```

## setting(xml)

### Context/WEB-INF/web.xml

```xml
 <servlet>
		<servlet-name>spring</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring-servlet.xml</param-value>			
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>spring</servlet-name>
		<url-pattern>*.yys</url-pattern>
		<!--  확장자가 yys여야만 통과한다. -->
	</servlet-mapping>
```

### Context/WEB-INF/spring-servlet.xml

```xml
	<bean class="org.springframework.web.servlet.view.UrlBasedViewResolver">
		<!-- 뷰 리졸빙(view resolving) : 디렉토리 찾아가는 서비스 -->
		<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"></property>
		<property name="prefix" value="/WEB-INF/view/"/>
		<property name="suffix" value=".jsp"/>
	</bean>
```
## Spring class and method

### org.springframework.ui.Model

|Modifier and Type|Method |and Description|
|---|---|---|
|Model|addAttribute(String attributeName, Object attributeValue)|Add the supplied attribute under the supplied name.|

```java
addAttribute
Model addAttribute(String attributeName,
                 Object attributeValue)
Add the supplied attribute under the supplied name.
Parameters:
attributeName - the name of the model attribute (never null)
attributeValue - the model attribute value (can be null)
```

### org.springframework.web.portlet.ModelAndView

|Modifier and Type|Method |and Description|
|---|---|---|
|ModelAndView|addObject(String attributeName, Object attributeValue)|Add an attribute to the model.|
|void|setViewName(String viewName)|Set a view name for this ModelAndView, to be resolved by the DispatcherPortlet via a ViewResolver.|

```java
public ModelAndView addObject(String attributeName,
                     Object attributeValue)
Add an attribute to the model.
Parameters:
attributeName - name of the object to add to the model
attributeValue - object to add to the model (never null)
See Also:
ModelMap.addAttribute(String, Object), getModelMap()
```

```java
public void setViewName(String viewName)
Set a view name for this ModelAndView, to be resolved by the DispatcherPortlet via a ViewResolver. 
Will override any pre-existing view name or View.
```

### org.springframework.beans.factory.annotation.Annotation Type Autowired

```
@Target(value={CONSTRUCTOR,FIELD,METHOD,ANNOTATION_TYPE})
@Retention(value=RUNTIME)
@Documented
public @interface Autowired
```

## Spring 하면서 중요한 개념 3가지

```
IOC
DI
AOP
```
