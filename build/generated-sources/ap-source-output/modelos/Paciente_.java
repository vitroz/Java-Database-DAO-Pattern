package modelos;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelos.Campus;
import modelos.PacientePK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-29T21:19:41")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, String> turma;
    public static volatile SingularAttribute<Paciente, String> raca;
    public static volatile SingularAttribute<Paciente, Date> dataNasc;
    public static volatile SingularAttribute<Paciente, String> naturalidade;
    public static volatile SingularAttribute<Paciente, String> telefone;
    public static volatile SingularAttribute<Paciente, String> sexo;
    public static volatile SingularAttribute<Paciente, String> nome;
    public static volatile SingularAttribute<Paciente, PacientePK> pacientePK;
    public static volatile SingularAttribute<Paciente, String> matricula;
    public static volatile SingularAttribute<Paciente, Campus> campus;

}