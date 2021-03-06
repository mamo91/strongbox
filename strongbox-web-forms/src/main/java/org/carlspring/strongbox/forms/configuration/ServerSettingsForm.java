package org.carlspring.strongbox.forms.configuration;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Pablo Tirado
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class ServerSettingsForm
{

    @NotBlank(message = "The name of this instance")
    @JsonProperty
    private String instanceName;

    @NotBlank(message = "A base URL must be specified.")
    @JsonProperty
    private String baseUrl;

    @Min(value = 1, message = "Port number must be an integer between 1 and 65535.")
    @Max(value = 65535, message = "Port number must be an integer between 1 and 65535.")
    @JsonProperty
    private int port;

    @Valid
    @JsonProperty
    private CorsConfigurationForm corsConfigurationForm = new CorsConfigurationForm();

    @Valid
    @JsonProperty
    private SmtpConfigurationForm smtpConfigurationForm = new SmtpConfigurationForm();

    @Valid
    @JsonProperty
    private ProxyConfigurationForm proxyConfigurationForm = new ProxyConfigurationForm();

    public ServerSettingsForm()
    {
    }

    public ServerSettingsForm(@NotBlank(message = "A base URL must be specified.") String baseUrl,
                              @Min(value = 1, message = "Port number must be an integer between 1 and 65535.")
                              @Max(value = 65535, message = "Port number must be an integer between 1 and 65535.") int port)
    {
        this.baseUrl = baseUrl;
        this.port = port;
    }

    public ServerSettingsForm(String baseUrl,
                              int port,
                              String instanceName,
                              CorsConfigurationForm corsConfigurationForm,
                              SmtpConfigurationForm smtpConfigurationForm,
                              ProxyConfigurationForm proxyConfigurationForm)
    {
        this.baseUrl = baseUrl;
        this.port = port;
        this.instanceName = instanceName;
        this.corsConfigurationForm = corsConfigurationForm;
        this.smtpConfigurationForm = smtpConfigurationForm;
        this.proxyConfigurationForm = proxyConfigurationForm;
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl)
    {
        this.baseUrl = baseUrl;
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

    public String getInstanceName()
    {
        return instanceName;
    }

    public void setInstanceName(String instanceName)
    {
        this.instanceName = instanceName;
    }

    public CorsConfigurationForm getCorsConfigurationForm()
    {
        return corsConfigurationForm;
    }

    public void setCorsConfigurationForm(CorsConfigurationForm corsConfigurationForm)
    {
        this.corsConfigurationForm = corsConfigurationForm;
    }

    public SmtpConfigurationForm getSmtpConfigurationForm()
    {
        return smtpConfigurationForm;
    }

    public void setSmtpConfigurationForm(SmtpConfigurationForm smtpConfigurationForm)
    {
        this.smtpConfigurationForm = smtpConfigurationForm;
    }

    public ProxyConfigurationForm getProxyConfigurationForm()
    {
        return proxyConfigurationForm;
    }

    public void setProxyConfigurationForm(ProxyConfigurationForm proxyConfigurationForm)
    {
        this.proxyConfigurationForm = proxyConfigurationForm;
    }
}
