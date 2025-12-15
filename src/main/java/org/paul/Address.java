package org.paul;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public Address(int streetNo, String street, String city, Province province, String postalCode) {

        if (isPostalCodeValid(postalCode)) {

            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode;

        } else {

            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }

    public static boolean isPostalCodeValid(String postalCode) {
        if ((postalCode == null) || (postalCode.length() != 6)) {
            return false;
        }

        for (int i = 0; i < postalCode.length(); i++) {
            char character = postalCode.charAt(i);

            if (i % 2 == 0) {
                if (!Character.isLetter(character)) {
                    return false;
                }
            } else {
                if (!Character.isDigit(character)) {
                    return false;
                }
            }
        }

        return true;
    }

    public enum Province {
        QC, ON, AB, SK, NL, MB, PEI, BC, NS, NB
    }

}
