import java.util.LinkedList;

public class interview {
    public static void main(String[] args) { //throws Exception 

    }

    LinkedList<listItem> merge(LinkedList<listItem> list1, LinkedList<listItem> list2) {

        listItem pointer1 = null;
        listItem pointer2 = null;

        LinkedList<listItem> returnList = new LinkedList<listItem>();

        for (int i = 0; i < list1.size() + list2.size(); i++) {
            
            if (pointer1 == null) {
                pointer1 = list1.pollFirst();
            }
            if (pointer2 == null) {
                pointer2 = list2.pollFirst();
            }
            if (pointer1 == null) {
                returnList.add(pointer2);
                continue;
            }
            if (pointer2 == null) {
                returnList.add(pointer1);
                continue;
            }

            if (pointer1.compareDate(pointer2) < 0) {
                returnList.add(pointer1);
                pointer1 = list1.pollFirst();
            } else {
                if (pointer1.getTask().compareTo(pointer2.getTask()) < 0) {
                    returnList.add(pointer1);
                    pointer1 = list1.pollFirst();
                } else {
                    returnList.add(pointer2);
                    pointer2 = list2.pollFirst();
                }
                
            }


        }

        return returnList;

    }

    LinkedList<listItem> timeRange(LinkedList<listItem> myList, int endYear, int endMonth, int endDay, int startYear, int startMonth, int startDay) {
        
        LinkedList<listItem> returnList = new LinkedList<listItem>();
        
        for (listItem myItem : myList) {
            if ((myItem.getYear() < endYear && myItem.getYear() > startYear) ||
                ((myItem.getYear() == endYear || myItem.getYear() == startYear) && (myItem.getMonth() < endMonth && myItem.getMonth() > startMonth)) ||
                (myItem.getYear() == endYear || myItem.getYear() == startYear) && (myItem.getMonth() == endMonth || myItem.getMonth() == startMonth) && (myItem.getDay() < endDay && myItem.getDay() > startDay)) {
                    returnList.add(myItem);
                    System.out.print(myItem.getTask() + ", Due: " + myItem.getMonth() + "/" + myItem.getDay() + "/" + myItem.getYear());
                    System.out.println();
                }
        }
        
        return returnList;
    }

    LinkedList<listItem> filter(boolean DATE, boolean PRIO, boolean ASSIGNED) {

        // simple to do, just filter throught the list and print just like in timeRange() if we hit the parameters
        return null;
    }

    LinkedList<listItem> csvRead(String path, String title) {

        // If I had time to do this one I would just use a java scanner

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
            if (toInsert.compareDate(myItem) < 0) {
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

    String getTask() {
        return task;
    }

    int compareDate(listItem o) {
        if (((this.getPriority() == o.getPriority()) && // if we are both prioirity or not prioirty
            ((this.getYear() < o.getYear()) || // check year first
            (this.getYear() == o.getYear() && this.getMonth() < o.getMonth()) || //then month
            (this.getYear() == o.getYear() && this.getMonth() == o.getMonth() && this.getDay() < o.getDay()))) || // then day
            (this.getPriority() == true && o.getPriority() == false)) { // if we are prioirty and the are not, we insert
            
            return -1;
        }
        if (this.getPriority() == o.getPriority() && this.getYear() == o.getYear() && this.getMonth() == o.getMonth() && this.getDay() == o.getDay()) {
            return 0;
        }
        
        return 1;
    }

}