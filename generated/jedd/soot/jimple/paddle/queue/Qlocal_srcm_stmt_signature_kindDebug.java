package soot.jimple.paddle.queue;

import soot.util.*;
import soot.jimple.paddle.bdddomains.*;
import soot.jimple.paddle.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qlocal_srcm_stmt_signature_kindDebug extends Qlocal_srcm_stmt_signature_kind {
    public Qlocal_srcm_stmt_signature_kindDebug(String name) { super(name); }
    
    private Qlocal_srcm_stmt_signature_kindBDD bdd = new Qlocal_srcm_stmt_signature_kindBDD(name + "bdd");
    
    private Qlocal_srcm_stmt_signature_kindSet trad = new Qlocal_srcm_stmt_signature_kindSet(name + "set");
    
    public void add(Local _local, SootMethod _srcm, Unit _stmt, NumberedString _signature, Kind _kind) {
        bdd.add(_local, _srcm, _stmt, _signature, _kind);
        trad.add(_local, _srcm, _stmt, _signature, _kind);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { kind.v(), stmt.v(), srcm.v(), local.v(), signature.v() },
                                              new PhysicalDomain[] { FD.v(), ST.v(), T1.v(), V1.v(), H2.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at /home/olhotak/soot-t" +
                                               "runk/src/soot/jimple/paddle/queue/Qlocal_srcm_stmt_signature" +
                                               "_kindDebug.jedd:39,22-24"),
                                              in).iterator(new Attribute[] { local.v(), srcm.v(), stmt.v(), signature.v(), kind.v() });
        while (it.hasNext()) {
            Object[] tuple = (Object[]) it.next();
            for (int i = 0; i < 5; i++) {
                this.add((Local) tuple[0],
                         (SootMethod) tuple[1],
                         (Unit) tuple[2],
                         (NumberedString) tuple[3],
                         (Kind) tuple[4]);
            }
        }
    }
    
    public Rlocal_srcm_stmt_signature_kind reader(String rname) {
        return new Rlocal_srcm_stmt_signature_kindDebug((Rlocal_srcm_stmt_signature_kindBDD) bdd.reader(rname),
                                                        (Rlocal_srcm_stmt_signature_kindSet) trad.reader(rname),
                                                        name + ":" +
                                                        rname);
    }
}