package model;

public class ServiceImplementation implements ServiceInterface {

    @Override
    public String execute() {
        return this + " executed";
    }

}
