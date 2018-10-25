import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Class for student.
 * Time complexity is 1.
 */
class Student implements Comparable<Student> {
    /**
     * { var_description }.
     */
    private String sName;
    /**
     * { var_description }.
     */
    private Date dob;
    /**
     * { var_description }.
     */
    private int sub1;
    /**
     * { var_description }.
     */
    private int sub2;
    /**
     * { var_description }.
     */
    private int sub3;
    /**
     * { var_description }.
     */
    private int total;
    /**
     * { var_description }.
     */
    private String rc;
    /**
     * { var_description }.
     */
    private boolean alloted;
    /**
     * Constructs the object based on the parameters.
     *
     * @param      studentNme  Student Name
     * @param      dateOfBirth  Date of Birth
     * @param      m11           Marks in first subject.
     * @param      m22           Marks in second subject.
     * @param      m33           Marks in third subject.
     * @param      total1           Total Marks.
     * @param      rc1          Reservation Category.
     * Time complexity is 1.
     */
    Student(final String studentNme, final String dateOfBirth,
                   final int m1, final int m2, final int m3, final int total1,
                   final String rc1) {
        this.sName = studentNme;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.dob = sdf.parse(dateOfBirth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.sub1 = m1;
        this.sub2 = m2;
        this.sub3 = m3;
        this.total = total1;
        this.rc = rc1;
        this.alloted = false;
    }
    /**
     * Gets the data of birth.
     * @return date of birth.
     * Time complexity is 1.
     */
    public Date getDob() {
        return dob;
    }
    /**
     * sets the student's date of birth.
     *
     * @param      b     [description]
     * Time complexity is 1.
     */
    public void setDb(final Date b) {
        this.dob = b;
    }
    /**
     * gets the date of birth.
     *
     * @return     the student's date of birth.
     * Time complexity is 1.
     */
    public String getRc() {
        return rc;
    }
    /**
     * Sets the student's reservation category.
     *
     * @param      r     { parameter_description }
     * Time complexity is 1.
     */
    public void setRc(final String r) {
        this.rc = r;
    }
    /**
     * gets the total marks.
     * @return returns the total marks of the student.
     * Time complexity is 1.
     */
    public int getTotal() {
        return total;
    }
    /**
     * sets the student's total marks.
     *
     * @param      m     { parameter_description }
     * Time complexity is 1.
     */
    public void setTotal(final int m) {
        this.total = m;
    }
    /**
     * Gets the student name.
     * @return the student's name.
     * Time complexity is 1.
     */
    public String getsName() {
        return sName;
    }
    /**
     * Sets the student name.
     * Time complexity is 1.
     *
     * @param      student  The student
     */
    public void setsName(final String student) {
        this.sName = student;
    }
    /**
     * Gets the marks in subject 1.
     * @return marks in subject 1.
     * Time complexity is 1.
     */
    public int getSub1() {
        return sub1;
    }
    /**
     * Sets the marks to subject 1.
     *
     * @param      m     { parameter_description }
     * Time complexity is 1.
     */
    public void setM1(final int m) {
        this.sub1 = m;
    }
    /**
     * Gets the marks in subject 2.
     * Time complexity is 1.
     *
     * @return     marks in subject 2.
     */
    public int getSub2() {
        return sub2;
    }
    /**
     * Sets marks in subject 2.
     * Time complexity is 1.
     *
     * @param      m     { parameter_description }
     */
    public void setM2(final int m) {
        this.sub2 = m;
    }
    /**
     * Gets the marks in subject 3.
     *
     * @return     sub3 Marks in subject 3.
     * Time complexity is 1.
     */
    public int getSub3() {
        return sub3;
    }
    /**
     * Sets the sub3 to the 3rd subject.
     * Time complexity is 1.
     *
     * @param      m     { parameter_description }
     */
    public void setSub3(final int m) {
        this.sub3 = m;
    }
    /**
     * Gets the alloted.
     *
     * @return     The alloted.
     */
    public boolean getAlloted() {
        return alloted;
    }
    /**
     * Sets the alloted.
     *
     * @param      allotment  The allotment
     */
    public void setAlloted(final boolean allotment) {
        this.alloted = allotment;
    }
    /**
     * Compares two objects of types students.
     * @param  that second Student.
     * @return integer based on the requirements.
     * Time complexity is 1.
     */
    public int compareTo(final Student that) {
        if (this.getTotal() > that.getTotal()) {
            return -1;
        }
        if (this.getTotal() < that.getTotal()) {
            return 1;
        }
        if (this.getSub3() > that.getSub3()) {
            return -1;
        }
        if (this.getSub3() < that.getSub3()) {
            return 1;
        }
        if (this.getSub2() > that.getSub2()) {
            return -1;
        }
        if (this.getSub2() < that.getSub2()) {
            return 1;
        }
        if (this.getDob().compareTo(that.getDob()) < 0) {
            return 1;
        }
        if (this.getDob().compareTo(that.getDob()) > 0) {
            return -1;
        }
        return 0;
    }
    /**
     * Gets the String version of the Students.
     * @return String version of object.
     * Time complexity is 1.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.getsName() + ",");
        sb.append(this.getTotal() + ",");
        sb.append(this.getRc());
        return sb.toString();
    }
}
/**
 * Class for heap.
 */
final class Heap {
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    private Heap() {
        //Unused Constructor.
    }
    /**
     * less method.
     * Time complexity is 1.
     *
     * @param      arr    { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private static boolean less(final Comparable[] arr,
        final int i, final int j) {
        return arr[i - 1].compareTo(arr[j - 1]) < 0;
    }
    /**
     * used to exchange.
     * Time complexity is 1.
     *
     * @param      arr    { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private static void exch(final Comparable[] arr, final int i, final int j) {
        Comparable swap = arr[i - 1];
        arr[i - 1] = arr[j - 1];
        arr[j - 1] = swap;
    }
    /**
     * Sink method.
     * Time complexity is logN.
     *
     * @param      arr    { parameter_description }
     * @param      k     { parameter_description }
     * @param      n     { parameter_description }
     */
    private static void sink(final Comparable[] arr, final int k, final int n) {
        int k1 = k;
        while (2 * k1 <= n) {
            int j = 2 * k1;
            if (j < n && less(arr, j, j + 1)) {
                j++;
            }
            if (!less(arr, k1, j)) {
                break;
            }
            exch(arr, k1, j);
            k1 = j;
        }
    }
    /**
     * Sort method.
     * Time complexity is logN.
     *
     * @param      arr    { parameter_description }
     */
    public static void sort(final Comparable[] arr) {
        int n = arr.length;
        for (int k = n / 2; k >= 1; k--) {
            sink(arr, k, n);
        }
        while (n > 1) {
            exch(arr, 1, n--);
            sink(arr, 1, n);
        }
    }
}

/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     * Time complexity is 1.
     */
    private Solution() {
        // default constructor.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int stdnts = Integer.parseInt(scan.nextLine());
        int vacancy = Integer.parseInt(scan.nextLine());
        int unRsrvd = Integer.parseInt(scan.nextLine());
        int noOfBC = Integer.parseInt(scan.nextLine());
        int noOfSC = Integer.parseInt(scan.nextLine());
        int noOfST = Integer.parseInt(scan.nextLine());
        Student[] students = new Student[stdnts];
        for (int k = 0; k < stdnts; k++) {
            String[] token = scan.nextLine().split(",");
            students[k] = new Student(
                token[0], token[1], Integer.parseInt(token[2]),
                Integer.parseInt(token[2 + 1]),
                Integer.parseInt(token[2 + 2]),
                Integer.parseInt(token[2 + 2 + 1]),
                token[2 + 2 + 2]);
        }
        Heap.sort(students);
        print(students);

        allotment(students, vacancy, unRsrvd, noOfBC,
                  noOfSC, noOfST);
    }
    /**
     * used to print.
     * Time complexity is N.
     *
     * @param      students  The students
     */
    public static void print(final Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
    /**
     * Alloting the seats to the students based on merit.
     * @param students  list of students.
     * @param vacancy number of vacancy.
     * @param unRsrvd Un-reserved category.
     * @param noBC      Number of BC seats.
     * @param noSC      Number of SC seats.
     * @param noST      Number of ST seats.
     * Time complexity is N.
     */
    public static void allotment(final Student[] students,
                                 final int vacancy,
                                 final int unRsrvd,
                                 final int noBC,
                                 final int noSC,
                                 final int noST) {
        int i = 0;
        int k = 0;
        int stdnts = students.length;
        int v = vacancy;
        int ct = unRsrvd;
        int bc = noBC;
        int sc = noSC;
        int st = noST;
        Student[] alloted = new Student[v];

        for (i = 0; i < stdnts; i++) {
            if (v == 0) {
                break;
            }

            if (ct > 0) {
                ct--;
                students[i].setAlloted(true);
                alloted[k++] = students[i];
                v--;
            }

            if (bc > 0) {
                if (students[i].getRc().equals("BC")
                    && !students[i].getAlloted()) {
                    bc--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    v--;
                }
            }

            if (sc > 0) {
                if (students[i].getRc().equals("SC")
                    && !students[i].getAlloted()) {
                    sc--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    v--;
                }
            }

            if (sc > 0) {
                if (students[i].getRc().equals("ST")
                    && !students[i].getAlloted()) {
                    st--;
                    students[i].setAlloted(true);
                    alloted[k++] = students[i];
                    v--;
                }
            }
        }

        for (i = 0; i < stdnts; i++) {
            if (v > 0 && students[i].getRc().equals("Open")
                && !students[i].getAlloted()) {
                students[i].setAlloted(true);
                alloted[k++] = students[i];
                v--;
            }
        }

        Heap.sort(alloted);
        print(alloted);
    }
}
