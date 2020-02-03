package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

/**
 *
 * Class for clac processes. Starts with parsing expr
 */
public class Parser {
    /**
     * size - max len of expr
     */
    private Stack<Double> stack = new Stack<>(1000);

    /**
     *
     * Takes expr returns calc results
     */
    public double calculate(String expr) throws Exception {

        stack.clear();
        String[] tokens = tokenize(expr);
        int length = tokens.length;

        for(int i = length - 1; i >= 0; i--) {
            process(tokens[i]);
        }

        if(stack.count() > 1)
            throw new IllegalArgumentException("2Many args");

        return stack.pop();
    }

    /**
     *
     * Method for parsing and evaluating input tokens
     */
    private void process(String token) throws Exception {

        try {
            if(!OpMap.Operations.containsKey(token)) {
                double argument = Double.parseDouble(token);
                stack.push(argument);
            } else {

                Operation op = OpMap.Operations.get(token);
                op.reset();

                try {
                    if (op.arity == 2) {
                        op.setArgument(stack.pop());
                        op.setArgument(stack.pop());
                    } else {
                        op.setArgument(stack.pop());
                    }
                } catch (Exception e) {
                    throw new Exception("2Less args");
                }

                if(op.readyToCalculate()) {
                    stack.push(op.execute());
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid line: " + token);
        }

    }

    /**
     *
     * Method for splitting an expression into parts - tokens
     */
    private String[] tokenize(String input) {
        return input.split("\\s+");
    }
}
