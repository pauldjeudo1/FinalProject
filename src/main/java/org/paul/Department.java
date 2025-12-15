package org.paul;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Department {
    private String departmentId;
    @Setter private String departmentName;
    private static int nextId = 1;

    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }

        for (char c : departmentName.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }

        return true;
    }

    public Department(String departmentName) {

        if (!isDepartmentNameValid(departmentName)) {
            this.departmentId = null;
            this.departmentName = null;

        } else {
            this.departmentName = Util.toTitlecase(departmentName);
            this.departmentId = "D" + String.format("%02d", nextId++);

        }
    }

}
