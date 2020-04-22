package Model;

public class Menu {
    private int optionId;
    private String option;
    private boolean active;

    public Menu(int optionId, String option, boolean active) {
        this.optionId = optionId;
        this.option = option;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }
}
