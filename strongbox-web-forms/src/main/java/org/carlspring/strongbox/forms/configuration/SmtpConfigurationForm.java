package org.carlspring.strongbox.forms.configuration;

import org.carlspring.strongbox.configuration.MutableSmtpConfiguration;
import org.carlspring.strongbox.configuration.SmtpConfiguration;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SmtpConfigurationForm
{

    @NotBlank(message = "SMTP host must be provided")
    private String host;

    @Min(value = 1, message = "Port number must be an integer between 1 and 65535.")
    @Max(value = 65535, message = "Port number must be an integer between 1 and 65535.")
    private Integer port;

    private String username;

    private String password;

    @Pattern(regexp = "plain|ssl|tls", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Please set a valid SMTP connection type.")
    private String connection;

    public SmtpConfigurationForm()
    {
    }

    public SmtpConfigurationForm(String host,
                                 Integer port,
                                 String connection,
                                 String username,
                                 String password)
    {
        this.host = host;
        this.port = port;
        this.connection = connection;
        this.username = username;
        this.password = password;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public Integer getPort()
    {
        return port;
    }

    public void setPort(Integer port)
    {
        this.port = port;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getConnection()
    {
        return connection;
    }

    public void setConnection(String connection)
    {
        this.connection = connection;
    }

    @JsonIgnore()
    public MutableSmtpConfiguration getMutableSmtpConfiguration()
    {
        return new MutableSmtpConfiguration(this.host,
                                            this.port,
                                            this.connection,
                                            this.username,
                                            this.password);
    }

    @JsonIgnore()
    public static SmtpConfigurationForm fromConfiguration(SmtpConfiguration source)
    {
        SmtpConfiguration configuration = Optional.ofNullable(source).orElse(
                new SmtpConfiguration(new MutableSmtpConfiguration())
        );

        return new SmtpConfigurationForm(configuration.getHost(),
                                         configuration.getPort(),
                                         configuration.getConnection(),
                                         configuration.getUsername(),
                                         null);
    }
}
