package com.coderhouse.session.seven;

public class Operation {

    private Double left;

    private Operator operator;

    private Double right;

    public Operation() {
    }

    public Operation(Double left, Operator operator, Double right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public Double getLeft() {
        return left;
    }

    public void setLeft(Double left) {
        this.left = left;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Double getRight() {
        return right;
    }

    public void setRight(Double right) {
        this.right = right;
    }
}
