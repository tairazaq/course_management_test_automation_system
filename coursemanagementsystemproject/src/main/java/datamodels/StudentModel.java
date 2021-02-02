package datamodels;

public class StudentModel {

    private String firstName;
    private String lastName;
    private String discriminator;


    public String getFirstName(){return firstName;}

    public void setFirstname(String firstName){
     this.firstName = firstName;
    };

    public String getLastName(){return lastName;}

    public void setLastname(String lastName){
        this.lastName = lastName;
    };

    public String getDiscriminator(String string){return discriminator;}

    public void setDiscriminator(String discriminator){
        this.discriminator = discriminator;
    };


}
