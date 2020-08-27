# GRAMMAR CHECKER
## Part I - Basic workshop 
1. Open the project sources in NetBeans.
2. Review the Spring configuration file already included in the project (src / main / resources). It indicates that Spring will automatically search for the 'Beans' available in the indicated package.
3. Making use of the Spring configuration based on annotations mark with the annotations @Autowired and @Service the dependencies that must be injected, and the 'beans' candidates to be injected -respectively-:
    
	* GrammarChecker will be a bean, which depends on something like 'SpellChecker'.   
	```java
    @Service
	public class GrammarChecker {
	@Autowired
	@Qualifier("Spanish")
	SpellChecker sc;
    ```
    * EnglishSpellChecker and SpanishSpellChecker are the two possible candidates to be injected. One must be selected, or another, but NOT both (there would be dependency resolution conflict). For now, have EnglishSpellChecker used.  
	```java
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        GrammarChecker gc=ac.getBean(GrammarChecker.class);
        System.out.println(gc.check("la la la "));
    }
    ```
4. Make a test program, where an instance of GrammarChecker is created by Spring, and use it:
    ```java
	@Component("English")
	public class EnglishSpellChecker implements SpellChecker {
		@Override
		public String checkSpell(String text) {		
			return "Checked with english checker:"+text;
		}		
	}
    ```
## Part II 
Modify the configuration with annotations so that the Bean 'GrammarChecker' now makes use of the SpanishSpellChecker class (so that GrammarChecker is injected with EnglishSpellChecker instead of SpanishSpellChecker.) Verify the new result.
	```java
    @Service
	public class GrammarChecker {
	@Autowired
	@Qualifier("Spanish")
	SpellChecker sc;
    ```
	
	