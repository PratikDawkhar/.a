#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<sys/wait.h>

char comm[80];
char *args[10];
int tot_arg,i,j;

void getcomm();
void sep_arg();
void take_action();
void count();
void main();

{
    int len;
    do
    {
        printf("myshell $");
        fgets(comm,80,stdin);
        len=strlen(comm);
        comm[len-1]='\0';

        if(strlen(comm)<=1)
            continue;
        sep_arg();

        take_action();
        for(i=0;i<tot_arg;i++)
            args[i]=NULL;
    }
    while(1);
    return;
}


void sep_arg()
  {
      char *token,*ptr;
      tot_arg=-1;
      ptr=comm;

      while(1)
      {
          token=strtok(ptr,"");
          if(token==NULL)
            break;
          args[++tot_arg]=(char *)malloc(strlen(token));
          strcpy(args[tot_arg],token);
          ptr=NULL;

      }

     return;
  }

void take_action()
 {
     int pid,status;
     char str[20];
     if(strcmp(args[0],"count")==0)
        count();
     else
     {
         pid=fork();
         if(pid==0)
         {
             execvp(args[0],args);
             strcpy(str,"./");
             strcat(str,args[0]);
             execvp(str,args);
             printf("\n%s:command not found \n",comm);
             exit(0);

         }
         else
            waitpid(pid,&status,0);

     }
 }



 void count()
 {

   int fd,ret,ccnt,wcnt,lcnt,wflag;
   char ch;
   fd=open(args[2],0);
   if(fd==-1)
   {
       printf("File not found..\n");
       return;
   }
   ccnt=wcnt=lcnt=0;
   wflag=0;
   ret=read(fd,&ch,1);
   while(ret!=0);
     {

         ccnt++;
         if(ch==''||ch=='\t')
         {
             if(wflag==0)
             {
                 wcnt++;
                 wflag=1;
             }
         }
         else
            if(ch=='\n')
         {

             lcnt==;
             if(wflag==0)
             {
                 wcnt++;
                 wflag=1;
             }
         }
         else
            wflag=0;
         ret=read(fd,&ch,1);

     }
     if(wflag==0)
     {

         wcnt++;
         lcnt++;
     }
     close(fd);
     if(strcmp(args[1],"c")==0)
        printf("\n No of chars:%d\n",ccnt);
     else
        if(strcmp(args[1],"w")==0)
        printf("\nNo of word:%d\n",wcnt);
     else
        if(strcmp(args[1],"l")==0)
        printf("\nNo of word:%d\n",lcnt);
     else
        printf("\n Invalid Option\n");

 }



 void list()
 {

      DIR*dp;
      struct dirent *dent;
      int cnt=0;
      dp=opendir(args[2]);
      if(dp==NULL)
      {
          printf("Directory NOT FOUND..");
          return;
      }
      dent=readdir(dp);
      while(dent!=NULL)
      {
          cnt++;
           if(strcmp(args[1],"f")==0)
             printf("%s\n",dent->d_name);
           else
            if(strcmp(args[1],"i")==0)
             printf("%s\t %ld")



      }
 }


 void search()
 {

      int fd,ret,n,cnt=0,totlines,i;
      char ch,buf[80];
      if(tot_arg<3)
        return;
      fd=open(args[3],0);
      if(fd==-1)
      {
          printf("File not found..\n");
          return;
      }
      i=-1;
      while((read(fd,&ch,1)!=0))
      {
          if(ch=='\n')
             buf[++i]='\0',i=-1;
          if(strstr(buf,args[2]!=NULL)
                 {
                  cnt++;
          if(strstr(buf,args[2])!=NULL)

          if(strcasecmp(args[1],"f")==0)
                    {
                     printf("%s\n",buf);
                     break;
                    }
            else
                if(strcasecmp(args[1],"a")==0)
                   printf("%s\n",buf);

                 }
          }
           else
             buf[++i]=ch;
      }//while
      if(strcasecmp(args[1],"c")==0)
        printf("%s occur %d times\n",args[2],cnt);
       close(fd);
 }


 void typeline()
 {

     int fd,ret,n,cnt=0,totlines;
     char ch;
     if(tot_arg<2)
        return;
     fd=open(args[2],0);
     if(fd==-1)
     {

         printf("File not found..\n");
         return;
     }
     if(strcmp(args[1],"a")==0)
     {
         ret=read(fd,&ch,1);
         while(ret!=0)
         {
             printf("%c",ch);
             ret=read(fd,&ch,1);
         }
     }
     else
        if(*args[1]=='+')
     {
         n=atoi(args[1]+1);
         ret=read(fd,&ch,1);
         cnt=0;
         while(ret!=0)
         {
             if(ch=='\n')
                cnt++;
             printf("%c",ch);
             if(cnt==n)
                break;
             ret=read(fd,&ch,1);
         }
     }
     else
        if(*args[1]=='-')
     {
         n=atoi(args[1]+1);
         totlines=0;
         ret=read(fd,&ch,1);
         while(ret!=0)
         {
             if(ch=='\n')
                totlines++;
             ret=read(fd,&ch,1);
         }
         cnt=0;
         lseek(fd,0,SEEK_set);
         ret=read(fd,&ch,1);
         while(ret!=0)
         {
             if(ch=='\n')
                cnt++;
             if(cnt>=totlines-n)
                printf("%c",ch);
             ret=read(fd,&ch,1);

         }
     }
     else
        printf("Invalid option\n");
         close(fd);
 }




