package com.fusion.gkquiz;
import java.util.List;

public class Model {

    String question;
    String Op1;
    String Op2;
    String Op3;
    String Op4;
    String rightAns;

    public Model() {
    }

    public Model(String question, String op1, String op2, String op3, String op4, String rightAns) {
        this.question = question;
        Op1 = op1;
        Op2 = op2;
        Op3 = op3;
        Op4 = op4;
        this.rightAns = rightAns;
    }

public String getQuestion() {
        return question;
    }

    public String getOp1() {
        return Op1;
    }

    public String getOp2() {
        return Op2;
    }

    public String getOp3() {
        return Op3;
    }

    public String getOp4() {
        return Op4;
    }

    public String getRightAns() {
        return rightAns;
    }

    public static void setTest(List<Model> list , int testNumber){

        if (testNumber==1){

            list.add(new Model("What is the main function of the mitochondria in a cell?", "Energy production", "Cell division", "Protein synthesis", "Waste elimination", "a"));

            list.add(new Model("Which force is responsible for the acceleration of an object near the Earth's surface?", "Gravitational force", "Electromagnetic force", "Strong nuclear force", "Weak nuclear force", "a"));

            list.add(new Model("What is the process by which plants make their own food using sunlight?", "Photosynthesis", "Respiration", "Digestion", "Fermentation", "a"));

            list.add(new Model("Which element is the most abundant in the Earth's crust?", "Oxygen", "Silicon", "Aluminum", "Iron", "b"));

            list.add(new Model("What is the function of the ozone layer in the Earth's atmosphere?", "Absorbing ultraviolet radiation", "Regulating temperature", "Producing oxygen", "Blocking visible light", "a"));

            list.add(new Model("Which of the following is a greenhouse gas?", "Carbon dioxide", "Nitrogen", "Oxygen", "Argon", "a"));

            list.add(new Model("What is the basic unit of heredity in living organisms?", "Gene", "Chromosome", "RNA", "Protein", "a"));

            list.add(new Model("Which planet is known as the 'Red Planet'?", "Mars", "Venus", "Jupiter", "Saturn", "a"));

            list.add(new Model("What is the speed of light in a vacuum?", "299,792 kilometers per second", "150,000 miles per hour", "500,000 meters per second", "1 million kilometers per hour", "a"));

            list.add(new Model("What is the role of white blood cells in the human body?", "Defending against infections", "Transporting oxygen", "Digesting food", "Producing hormones", "a"));

        }
        else if (testNumber==2) {
            list.add(new Model("What is the correct definition of a palindrome?", "A word, phrase, or sequence that reads the same backward as forward", "A complex mathematical equation", "A type of tropical fruit", "A large body of water", "a"));

            list.add(new Model("Which literary device involves the repetition of consonant sounds at the beginning of words in close proximity?", "Alliteration", "Simile", "Metaphor", "Onomatopoeia", "a"));

            list.add(new Model("What is the purpose of using foreshadowing in literature?", "Hinting at future events", "Providing historical context", "Describing the setting in detail", "Introducing main characters", "a"));

            list.add(new Model("Which of the following is an example of a simile?", "As brave as a lion", "The sun smiled down on us", "Time is a thief", "The wind whispered through the trees", "a"));

            list.add(new Model("What is the main idea of a piece of writing?", "The central point or message", "The number of words used", "The author's biography", "The publication date", "a"));

            list.add(new Model("What is the definition of an allegory in literature?", "A story with a symbolic meaning", "A humorous play", "A tragic love story", "A historical account", "a"));

            list.add(new Model("Which literary term refers to the emotional atmosphere or feeling in a work of literature?", "Mood", "Tone", "Theme", "Plot", "a"));

            list.add(new Model("What is the purpose of a thesis statement in an essay?", "Expressing the main idea or argument", "Providing background information", "Listing supporting details", "Concluding the essay", "a"));

            list.add(new Model("Which punctuation mark is used to indicate possession?", "Apostrophe", "Comma", "Colon", "Semicolon", "a"));

            list.add(new Model("What is the definition of a metaphor in literature?", "A figure of speech comparing two unlike things without using 'like' or 'as'", "A direct comparison using 'like' or 'as'", "A short and humorous story", "An exaggerated statement", "a"));
        }
        else if (testNumber==3) {
            list.add(new Model("What is the smallest unit of an element that retains its chemical properties?", "Atom", "Molecule", "Ion", "Compound", "a"));

            list.add(new Model("Which type of chemical bond involves the sharing of electrons between atoms?", "Covalent bond", "Ionic bond", "Metallic bond", "Hydrogen bond", "a"));

            list.add(new Model("What is the chemical symbol for the element gold?", "Au", "Ag", "Fe", "Cu", "a"));

            list.add(new Model("What is the pH scale used to measure?", "Acidity or alkalinity of a solution", "Temperature of a substance", "Pressure in a reaction vessel", "Concentration of electrons in a compound", "a"));

            list.add(new Model("Which gas makes up the majority of Earth's atmosphere?", "Nitrogen", "Oxygen", "Carbon dioxide", "Hydrogen", "a"));

            list.add(new Model("What is the process of a substance changing from a gas to a liquid?", "Condensation", "Evaporation", "Sublimation", "Freezing", "a"));

            list.add(new Model("Which group of elements on the periodic table is known as the noble gases?", "Group 18", "Group 1", "Group 17", "Group 2", "a"));

            list.add(new Model("What is the chemical formula for water?", "H₂O", "CO₂", "O₂", "NaCl", "a"));

            list.add(new Model("Which type of reaction involves the combination of two or more substances to form a new substance?", "Synthesis reaction", "Decomposition reaction", "Combustion reaction", "Replacement reaction", "a"));

            list.add(new Model("What is the role of a catalyst in a chemical reaction?", "Speeding up the reaction rate", "Slowing down the reaction rate", "Initiating the reaction", "Changing the color of the products", "a")); } else if (testNumber == 4){
            list.add(new Model("What is the primary function of the legislative branch in a democratic government?", "Making laws", "Enforcing laws", "Interpreting laws", "Approving budgets", "a"));

            list.add(new Model("Who is considered the 'Father of Economics' and authored 'The Wealth of Nations'?", "Adam Smith", "Karl Marx", "John Maynard Keynes", "Milton Friedman", "a"));

            list.add(new Model("What is the concept of 'cultural diffusion' in anthropology?", "The spread of cultural elements from one society to another", "The preservation of cultural traditions", "The isolation of cultures", "The dominance of one culture over others", "a"));

            list.add(new Model("Which economic system is characterized by private ownership of the means of production and free-market competition?", "Capitalism", "Socialism", "Communism", "Fascism", "a"));

            list.add(new Model("What is the primary focus of sociology?", "Study of society and human social behavior", "Analysis of economic systems", "Exploration of political ideologies", "Examination of individual psychology", "a"));

            list.add(new Model("Who developed the theory of psychoanalysis and explored the role of the unconscious mind?", "Sigmund Freud", "B.F. Skinner", "Ivan Pavlov", "Jean Piaget", "a"));

            list.add(new Model("What is the purpose of the United Nations (UN)?", "Promoting international cooperation and peace", "Facilitating global trade", "Enforcing world laws", "Creating a global currency", "a"));

            list.add(new Model("In political science, what is the term for a government ruled by a single individual with absolute power?", "Autocracy", "Oligarchy", "Democracy", "Republic", "a"));

            list.add(new Model("What is the main focus of environmental geography?", "Study of the interaction between human societies and the environment", "Analysis of political borders", "Investigation of historical events", "Exploration of cultural practices", "a"));

            list.add(new Model("Who is credited with developing the theory of cognitive development in children?", "Jean Piaget", "Lev Vygotsky", "Erik Erikson", "Lawrence Kohlberg", "a"));}
        else if (testNumber == 5){
            list.add(new Model("Which imaginary line divides the Earth into the Northern and Southern Hemispheres?", "Equator", "Prime Meridian", "Tropic of Cancer", "Tropic of Capricorn", "a"));

            list.add(new Model("What is the largest ocean on Earth?", "Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Southern Ocean", "b"));

            list.add(new Model("Which mountain range separates Europe and Asia?", "Ural Mountains", "Himalayas", "Andes", "Alps", "c"));

            list.add(new Model("What is the capital city of Australia?", "Canberra", "Sydney", "Melbourne", "Brisbane", "a"));

            list.add(new Model("Which river is the longest in the world?", "Nile River", "Amazon River", "Yangtze River", "Mississippi River", "b"));

            list.add(new Model("What is the term for a large body of ice that flows slowly over land?", "Glacier", "Tundra", "Plateau", "Steppe", "a"));

            list.add(new Model("Which desert is the largest hot desert in the world?", "Sahara Desert", "Arabian Desert", "Gobi Desert", "Karakum Desert", "a"));

            list.add(new Model("What is the capital city of Canada?", "Ottawa", "Toronto", "Vancouver", "Montreal", "a"));

            list.add(new Model("Which continent is known as the 'Land Down Under'?", "Australia", "Africa", "South America", "Antarctica", "a"));

            list.add(new Model("What is the Great Barrier Reef?", "The world's largest coral reef system", "A mountain range in North America", "A desert in Africa", "A plateau in Asia", "a"));
        }
        else if (testNumber == 6) {
            list.add(new Model("What does CPU stand for?", "Computer Personal Unit", "Central Process Unit", "Central Processor Unit", "Central Processing Unit", "d"));

            list.add(new Model("Which programming language is known for its simplicity and readability, using indentations for code blocks?", "Java", "Python", "C++", "JavaScript", "a"));

            list.add(new Model("What is the purpose of an operating system?", "Running web browsers", "Storing data on a computer", "Designing graphics for games", "Managing computer hardware and software resources", "d"));

            list.add(new Model("Which type of memory is volatile and loses its data when the power is turned off?", "ROM (Read-Only Memory)", "Cache Memory", "Secondary Memory", "RAM (Random Access Memory)", "a"));

            list.add(new Model("What does URL stand for in the context of the internet?", "Universal Resource Locator", "Uniform Retrieval Locator", "Uniform Resource Locator", "Universal Retrieval Locator", "c"));

            list.add(new Model("Which data structure follows the Last In, First Out (LIFO) principle?", "Queue", "Linked List", "Array", "Stack", "d"));

            list.add(new Model("What is the function of a firewall in computer security?", "Enhancing computer performance", "Detecting and removing viruses", "Backing up data", "Monitoring and controlling incoming and outgoing network traffic", "a"));

            list.add(new Model("Which programming paradigm emphasizes the use of functions and avoids changing state and mutable data?", "Object-oriented programming", "Procedural programming", "Imperative programming", "Functional programming", "d"));

            list.add(new Model("What is the purpose of HTML in web development?", "Programming language for backend development", "Database management language", "Network protocol for data transfer", "Markup language for creating web pages", "d"));

            list.add(new Model("What is the primary role of a compiler in the context of programming languages?", "Executing code line by line", "Debugging programs", "Managing database operations", "Translating high-level code into machine code", "a"));

        }

        else {
            list.add(new Model("In Java, what is the purpose of the 'default' case in a switch statement?", "To specify the default value of a variable", "To handle exceptions", "To execute code when none of the other cases match", "To define a constructor", "c"));

            list.add(new Model("Which Java keyword is used to create a new instance of a class?", "new", "create", "instance", "instantiate", "a"));

            list.add(new Model("What is the term for a Java construct that allows you to define a group of related constants with associated values?", "Package", "Enum", "Interface", "Module", "b"));

            list.add(new Model("In Java, which exception is thrown when you try to access an object that is set to null?", "ArrayIndexOutOfBoundsException", "NullPointerException", "ArithmeticException", "IllegalArgumentException", "b"));

            list.add(new Model("What is the Java keyword used to specify a method that is not implemented in the current class but must be implemented by any concrete subclass?", "abstract", "implements", "extends", "override", "a"));

            list.add(new Model("In Java, which access modifier allows a class or member to be accessed only within the same package and its subclasses?", "public", "private", "protected", "package-private", "d"));

            list.add(new Model("What is the Java keyword used to specify a block of code that will be executed after a try-catch block, regardless of whether an exception occurred or not?", "try", "catch", "throw", "finally", "d"));

            list.add(new Model("Which Java operator is used to compare two values for equality, regardless of their data types?", "==", "=", "!=", "===", "d"));

            list.add(new Model("In Java, what is the term for a method that has the same name as another method in the same class with the same parameter list?", "Duplicate method", "Overloaded method", "Inherited method", "Private method", "b"));

            list.add(new Model("What is the purpose of the 'instanceof' operator in Java?", "To compare two strings", "To check if an object is an instance of a particular class or interface", "To perform arithmetic operations", "To create new instances of a class", "b"));
        }
    }

}
