package abstractFactoryPattern.models.plant;

import abstractFactoryPattern.interfaces.Plant;

public abstract class PlantImpl implements Plant{

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
