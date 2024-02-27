public class NotesNumberCriteria1 {
    public static int howManyOldPeople(Person[] people) {
        int count = 0;
        for (Person person : people) {
            if (person.getAge() > 60) {
                count++;
            }
        }
        return count;
    }
    
    public static int howManyOldPeople(Person[][] people) {
        int count = 0;
        for (Person[] row : people) {
            for (Person person : row) {
                if (person.getAge() > 60) {
                    count++;
                }
            }
        }
        return count;
    }
}
