package com.venkat.lambda.ex;

public class LambdaScope extends SuperScope {
    private String member = "GRANDPA";

    interface Family {
        String who(String member);
    }

    public void testMember(String member){
        System.out.println("Local member: " + member);
        System.out.println("Family member: " + this.member);
        System.out.println("Family member: " + super.member);

        Family family = (familyMember) -> {
            System.out.println("***************");
            System.out.println("Local member: " + familyMember);
            System.out.println("Local member: " + member);
            System.out.println("Family member: " + this.member);
            System.out.println("Family member: " + super.member);

            return familyMember;
        };

        family.who(member);
    }

    public static void main(String[] args) {
        new LambdaScope().testMember("SON");
    }
}
