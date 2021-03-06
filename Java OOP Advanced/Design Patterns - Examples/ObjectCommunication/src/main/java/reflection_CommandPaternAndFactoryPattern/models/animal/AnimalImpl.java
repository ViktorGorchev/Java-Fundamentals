package reflection_CommandPaternAndFactoryPattern.models.animal;

import reflection_CommandPaternAndFactoryPattern.interfaces.Animal;

public abstract class AnimalImpl implements Animal {
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
