package com.coderhouse.session.seven;

public class OperationResult {

    private Double left;

    private Operator operator;

    private Double right;

    private Double result;

    public OperationResult() {
    }

    public OperationResult(Double left, Operator operator, Double right, Double result) {
        this.left = left;
        this.operator = operator;
        this.right = right;
        this.result = result;
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

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
