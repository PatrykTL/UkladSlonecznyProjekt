package back;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Sun {
    private BigDecimal mass;
    public Sun(BigDecimal masa)
    {
        this.mass=masa;
    }
    public BigDecimal getMass(){
        return mass;
    }

}
