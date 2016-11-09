package commandPatternWithCreateCommand.models;

import commandPatternWithCreateCommand.interfaces.Animal;

public abstract class AnimalImpl implements Animal{
    private String type;

    protected AnimalImpl(String type) {
        this.setType(type);
    }

    @Override
    public String getType() {
        return this.type;
    }

    private void setType(String type) {
        this.type = type;
    }
}
