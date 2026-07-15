package LLD.SolidPrinciples.SingleResponsibilityP;

import java.util.List;

//Single responsoibility principle
//class should have only one responsibility
//project -- have different classes for controllers / repositories / Service and so on

public abstract  class OrderRepository {

    abstract List<String> findAll();


}
