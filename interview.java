import java.util.LinkedList;

public class interview {
    public static void main(String[] args) { //throws Exception 

    }

    LinkedList<listItem> merge(LinkedList<listItem> list1, LinkedList<listItem> list2) {

        listItem pointer1;
        listItem pointer2;

        LinkedList<listItem> returnList = new LinkedList<listItem>();

        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < list1.size() + list2.size(); i++) {
            
            if (pointer1 == null) {
                pointer1 = list1.poll();
            }

            if (pointer2 == null) {
                pointer2 = list2.poll();
            }
            
            if (pointer1.compareDate(pointer2) > 0) {
                returnList.add(pointer1);
            }

            if (pointer2.compareDate(pointer1) > 0) {
                returnList.add(pointer2);
            }
            

        }

        return null;

    }
}

// TODO: resort the list if we change the date

class todo {
    private String title;
    private String owner;
    private LinkedList<listItem> myTodo;

    todo(String myTitle, String myOwner) {
        title = myTitle;
        owner = myOwner;
        myTodo = new LinkedList<listItem>();
    }

    void add(listItem toInsert) {
        if (myTodo.size() == 0) {
            myTodo.add(toInsert);
            return;
        }
            int i = 0;
        for (listItem myItem : myTodo) { // insertion sort
            if (toInsert.compareDate(myItem) > 0) {
                myTodo.add(i, toInsert);
            }
            
            i++;
        }
    }

    String getTitle() {
        return title;
    }

    String getOwner() {
        return owner;
    }

}


class listItem {
    
    private String task;
    private int year;
    private int month;
    private int day;
    private String assignee;
    private boolean priority;
    private boolean completion;

    listItem(String task) {
        this.task = task;
    }

    // assignee, duedate, priority

    void setTask (String newTask) {
        task = new String(newTask);
        completion = false;
        priority = false;
    }

    void setDate(int myYear, int myMonth, int myDay) { 
        year = myYear;
        month = myMonth;
        day = myDay;
    }

    void setAssignee (String newAssignee) {
        assignee = newAssignee;
    }

    void setPriority () {
        priority = true;
    }

    void setComplete() {
        completion = true;
    }

    int getYear() {
        return year;
    }

    int getMonth() {
        return month;
    }

    int getDay() {
        return day;
    }

    boolean getPriority() {
        return priority;
    }

    int compareDate(listItem o) {
        if (((this.getPriority() == o.getPriority()) && // if we are both prioirity or not prioirty
            ((this.getYear() < o.getYear()) || // check year first
            (this.getYear() == o.getYear() && this.getMonth() < o.getMonth()) || //then month
            (this.getYear() == o.getYear() && this.getMonth() == o.getMonth() && this.getDay() < o.getDay()))) || // then day
            (this.getPriority() == true && o.getPriority() == false)) { // if we are prioirty and the are not, we insert
            
            return 1;
        }
        if (this.getPriority() == o.getPriority() && this.getYear() == o.getYear() && this.getMonth() == o.getMonth() && this.getDay() == o.getDay()) {
            return 0;
        }
        
        return -1;
    }

}