package raisetech.Student.Manager.date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Student {

  private String id;
  private String name;
  private String furigana;
  private String nickname;
  private String emailAddress;
  private String address;
  private int age;
  private String gender;
  private String remark;
  private boolean isDelete;

}
