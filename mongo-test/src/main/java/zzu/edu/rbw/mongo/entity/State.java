package zzu.edu.rbw.mongo.entity;

public enum State {
    ACTIVE(1), SLIENCE(0);

    private int value;

    State(int value){
        this.value = value;
    }

    //public static State getStateByValue
}
