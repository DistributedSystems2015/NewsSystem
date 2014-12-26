namespace NewsSystem.Api.Socket
{
    using Newtonsoft.Json;
    using System;
    using System.IO;
    using System.Linq;
    using System.Net;
    using System.Net.Sockets;
    using System.Text;
    using System.Xml.Serialization;

    public class SocketClient
    {
        private static SocketClient instance;

        private Socket socket;

        private SocketClient()
        {
            this.socket = new Socket(
                AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
        }

        public static SocketClient Instance
        {
            get
            {
                if (instance == null)
                {
                    instance = new SocketClient();
                }

                return instance;
            }
        }

        public void Connect()
        {
            IPHostEntry ipHostInfo = Dns.GetHostEntry("localhost");
            IPAddress ipAddress = ipHostInfo.AddressList
                .FirstOrDefault(item => item.AddressFamily == AddressFamily.InterNetwork);
            IPEndPoint remoteEP = new IPEndPoint(ipAddress, 11000);

            this.socket.Connect(remoteEP);
        }

        public T Send<T>(SocketRequest request)
            where T : class
        {
            string requestMessage = JsonConvert.SerializeObject(request);
            byte[] requestMessageBytes = Encoding.UTF8.GetBytes(requestMessage);
            this.socket.Send(requestMessageBytes);

            byte[] responseMessageBytes = new byte[10240];
            int receivedBytes = this.socket.Receive(responseMessageBytes);
            string responseMessage = Encoding.UTF8.GetString(responseMessageBytes, 0, receivedBytes);
            return JsonConvert.DeserializeObject<T>(responseMessage);
        }

        public void Disconnect()
        {
            this.socket.Shutdown(SocketShutdown.Both);
            this.socket.Close();
        }
    }
}