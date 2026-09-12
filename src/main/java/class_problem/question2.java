package class_problem;

public class question2 {

        static String findDuplicateTeam(String[] names) {
            for (int i = 0; i < names.length; i++)
                for (int j = i + 1; j < names.length; j++)
                    if (names[i].equals(names[j]))
                        return "Duplicate Found: " + names[i];
            return "No Duplicates Found";
        }
        public static void main(String[] args) {
            String[] names = {"ByteForce", "CodeCrafters", "ByteForce"};
            System.out.println(findDuplicateTeam(names));
        }
    }

