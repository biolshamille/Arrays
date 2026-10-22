public class ClassRankingSystem {

    static class Student {
        String name;
        int[] quizzes;
        double average;

        Student(String name, int[] quizzes) {
            this.name = name;
            this.quizzes = quizzes;

            int total = 0;

            for (int i = 0; i < quizzes.length; i++) {
                total += quizzes[i];
            }

            average = (double) total / quizzes.length;
        }
    }

    public static void sortStudents(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                boolean swap = students[j].average
                        < students[j + 1].average;

                if (students[j].average == students[j + 1].average) {
                    swap = students[j].name.compareToIgnoreCase(
                            students[j + 1].name) > 0;
                }

                if (swap) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    public static int findRank(Student[] students, String targetName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].name.equalsIgnoreCase(targetName)) {
                int rank = 1;

                for (int j = 0; j < students.length; j++) {
                    if (students[j].average > students[i].average) {
                        rank++;
                    }
                }

                return rank;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] names = {
            "Alice", "Brian", "Carla", "David", "Ella"
        };

        int[][] quizData = {
            {90, 85, 88, 92},
            {78, 80, 82, 84},
            {95, 93, 97, 95},
            {88, 88, 88, 88},
            {95, 93, 97, 95}
        };

        Student[] students = new Student[names.length];

        for (int i = 0; i < names.length; i++) {
            students[i] = new Student(names[i], quizData[i]);
        }

        sortStudents(students);

        System.out.println("CLASS LEADERBOARD");
        System.out.println("--------------------------------");

        for (int i = 0; i < students.length; i++) {
            int rank = findRank(students, students[i].name);

            System.out.printf(
                "Rank: %d | Name: %-8s | Average: %.2f%n",
                rank,
                students[i].name,
                students[i].average
            );
        }

        String searchName = "Brian";
        int rank = findRank(students, searchName);

        System.out.println("--------------------------------");

        if (rank != -1) {
            System.out.println(searchName + "'s Rank: " + rank);
        } else {
            System.out.println("Student not found.");
        }
    }
}
