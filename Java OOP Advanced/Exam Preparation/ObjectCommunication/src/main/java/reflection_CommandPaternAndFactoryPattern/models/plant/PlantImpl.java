package reflection_CommandPaternAndFactoryPattern.models.plant;

import reflection_CommandPaternAndFactoryPattern.interfaces.Plant;

public abstract class PlantImpl implements Plant {

    private String type;

    protected PlantImpl(String type) {
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
