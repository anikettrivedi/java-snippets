package random;

public class CountChars {
    public static void main(String[] args) {
        String sentence = """
                Hello!
                I am a Java Developer with 5.5+ years of experience working with modern Java based technologies like Spring, Spring Boot, Kafka, Hadoop, etc.          
                As a hands-on developer, I have created and I continue to create scalable microservices that handle high volumes of data (and events) in an efficient manner.
                As a programmer, I am quite proactive, I always stress on writing clean code with high emphasis on running solutions locally first. I strongly believe that highly complex and scalable solutions are really very simple at their core, as long as we keep all the individual components that make them simple.
                I am capable of working both as a highly productive team player and as an efficient individual contributor. I like to help my teammates in resolving their complex technical queries and I have a great eye for investigating and fixing bugs in code.
                I am looking forward for job opportunities in West Europe (preferably Belgium, Netherlands or Luxembourg).
                Cheers,
                Aniket
                """;
        System.out.println("Character count = " + sentence.length());
        System.out.println(sentence);
    }
}
