package App;

public class User {

   private String Nickname;
   private String Password;
   private boolean role1 = false;
   private boolean role2 = false;
   private boolean role3 = false;

   public User(String nickname, String password, String Role) {
      Nickname = nickname;
      Password = password;
      if (Role.equals("Tres"))
         this.role1 = true;
      else if (Role.equals("Comms"))
         this.role2 = true;
      else
         this.role3 = true;
   }

   public String getNickname() {
      return Nickname;
   }

   public void setNickname(String nickname) {
      Nickname = nickname;
   }

   public String getPassword() {
      return Password;
   }

   public void setPassword(String password) {
      Password = password;
   }

   public boolean isTreas() {
      return role1;
   }

   public void setTreas(boolean role1) {
      this.role1 = role1;
   }

   public boolean isComms() {
      return role2;
   }

   public void setComms(boolean role2) {
      this.role2 = role2;
   }

   public boolean isPres() {
      return role3;
   }

   public void setPres(boolean role3) {
      this.role3 = role3;
   }
}
