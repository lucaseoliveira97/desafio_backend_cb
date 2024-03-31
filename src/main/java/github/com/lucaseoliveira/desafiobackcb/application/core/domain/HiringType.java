package github.com.lucaseoliveira.desafiobackcb.application.core.domain;

public enum HiringType {
    OUTSOURCING("OUT"),
    CLT("CLT"),
    PESSOA_JURIDICA("PJ");

    private final String abbr;

    HiringType(String abbr)
    {
        this.abbr = abbr;
    }
    String getAbbr()
    {
        return abbr;
    }
}
