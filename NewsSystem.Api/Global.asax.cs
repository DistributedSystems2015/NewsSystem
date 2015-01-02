namespace NewsSystem.Api
{
    using NewsSystem.Api.Socket;
    using System.Web;
    using System.Web.Http;

    public class WebApiApplication : HttpApplication
    {
        protected void Application_Start()
        {
            UnityConfig.RegisterComponents();
            GlobalConfiguration.Configure(WebApiConfig.Register);
            //SocketClient.Instance.Connect();
        }

        protected void Application_End()
        {
            //SocketClient.Instance.Disconnect();
        }
    }
}
