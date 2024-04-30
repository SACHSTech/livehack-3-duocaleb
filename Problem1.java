class Problem1 extends ConsoleProgram {

  /**
   * Description
   * 
   * @author: Caleb Chang
   */

  public void run() {
    ;
    System.out.println("***** Student Account Registration *****");
    String firstName = readLine("Enter your first name: ");
    String lastName = readLine("Enter your last name: ");
    String studNum = readLine("Enter your student number: ");
    String userName = readLine("Enter a new username: ");

    System.out.println();
    System.out.println("Valid username: " + validateUsername(userName));
    System.out.println("Your password is: " + createPassword(firstName, lastName, studNum));
  }

  /**
   * Checks if the username given is valid or not.
   *
   * @param strUsername The inputed username
   * @return Returns a boolean with whether the username is valid or not
   */
  public boolean validateUsername(String strUsername) {
    if (strUsername.length() > 7) {
      // Setting up a variable
      boolean intNumCount = false;

      // Making the method check if the method contains any numbers, also makes it
      // check if it has anything other than numbers or characters.
      for (int intUsernameLength = 0; intUsernameLength < strUsername.length(); intUsernameLength++) {
        if (intNumCount == false && (int) strUsername.charAt(intUsernameLength) >= 48
            && (int) strUsername.charAt(intUsernameLength) <= 57) {
          intNumCount = true;
        }
        
        //If its not a number(checked from the first one) and not a letter(checked here), it is not valid. 
        else if (((int) strUsername.toUpperCase().charAt(intUsernameLength) >= 65 
                 && (int) strUsername.toUpperCase().charAt(intUsernameLength) <= 90) != true) {
          return (false);
        }

      }

      if (intNumCount) {
        return (true);
      } 
      else {
        return (false);
      }
    } 
    else {
      return (false);
    }
  }

  /**
   * Creates a password for a student
   *
   * @param strFirstName     Student's first name.
   * @param strLastName      Studnet's last name.
   * @param strStudentNumber Student's number.
   * @throws IllegalArgumentException if strFirstName is blank or
   *                                  strLastName is blank or
   *                                  the length of strStudentNumber != 9
   * @return Returns the password of a student based on the parameters
   */
  public String createPassword(String strFirstName, String strLastName, String strStudentNumber) {
    // Enforcing the conditions
    if (strStudentNumber.length() != 9 || strFirstName.equals("") || strLastName.equals("")) {
      // Messed up the grammar here by putting s twice
      throw new IllegalArgumentException("incorrect parameters(s)");
    }

    // Setting up Password variable
    String Password = "";

    // Adding the various parts of the password
    if (strLastName.length() < 4) {
      Password += strLastName.toLowerCase();
    } else {
      Password += strLastName.substring(0, 4).toLowerCase();
    }

    Password += strFirstName.toUpperCase().charAt(0);
    Password += strStudentNumber.substring(3, 6);

    // Returning the password as a string.
    return (Password);
  }

}