package com.tsidylo.practice;

// import com.fathzer.soft.javaluator.DoubleEvaluator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PracticeApplication {

    //   private static Logger LOG = LoggerFactory.getLogger(PracticeApplication.class);
    //   private final EquationService equationService;
//
    //   @Autowired
    //   public PracticeApplication(EquationService equationService) {
    //       this.equationService = equationService;
    //   }

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }
/*
    public String readLine() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Exception during line reading");
            return null;
        }
    }

    @Override
    public void run(String... args) {

        while (true) {
            System.out.println("1. Enter equation");
            System.out.println("2. Enter solutions");
            System.out.println("3. Find equation by solution");
            System.out.println("4. Exit");

            String line = readLine();

            if (line == null) {
                continue;
            } else if (line.equals("1")) {
                enterEquation();

            } else if (line.equals("2")) {
            } else if (line.equals("3")) {
            } else if (line.equals("4")) {
                break;
            }
        }


        // Printing the read line


    }


    public void enterEquation() {
        String equation = readLine();

        if (equationService.areEquationCorrect(equation)) {
            equationService.saveNewEquation(equation);
            System.out.println("Everything correct and saved");

            DoubleEvaluator evaluator = new DoubleEvaluator();
            String expression = "(2*3-1)*(20/4)/(1*2)";
            Double result = evaluator.evaluate(expression);

            System.out.println(result);
        } else {
            System.out.println("Equation is incorrect and wouldn't be saved");
        }
    }
*/
}
