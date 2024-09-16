package kdu.backend3;

class Factorial implements Runnable
{
    Thread t;
    int n;

    Factorial(int x)
    {
        n = x;
        t=new Thread(this,"Factorial Thread");
        Logging.logInfo("\nFactorial thread created : "+t);
        t.start();
    }

    public void run()
    {
        try
        {
            long f = 1;
            for(int i = 2;i<=n;i++)
            {
                f*=i;
            }
            Logging.logInfo("Factorial of "+n+" is : "+f);
        }
        catch (Exception e)
        {
            Logging.logInfo(e.getMessage());
        }
        Logging.logInfo("\nExiting "+t);
    }
}