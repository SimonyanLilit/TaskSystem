public class Plane {
    private String name;
    private int relDate;
    private int hour;
    private boolean isMilitary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRelDate() {
        return relDate;
    }

    public void setRelDate(int relDate) {
        this.relDate = relDate;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isMilitary() {
        return isMilitary;
    }

    public void setMilitary(boolean military) {
        isMilitary = military;
    }


    public void printInfo(){
        System.out.printf("Name= %s,Year= %d,Hours= %d, Is military =%s",name,relDate,hour,isMilitary? "yes":"no");
    }
}
