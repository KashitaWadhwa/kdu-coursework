package kdu.backend3;

class Factor implements Runnable
{
    Thread t;
    int n;

    Factor(int x)
    {
        n = x;
        t=new Thread(this,"Factor Thread");
        Logging.logInfo("\nFactor thread created : "+t);
        t.start();
    }

    public void run()
    {
        try
        {
            Logging.logInfo("Factors of "+n+" are : ");
            for(int i = 1;i<=n;i++)
            {
                if(n%i == 0 )
                    Logging.logInfo(i+" ");
            }
        }
        catch (Exception e)
        {
            Logging.logInfo(e.getMessage());
        }
        Logging.logInfo("\nExiting "+t);
    }
}