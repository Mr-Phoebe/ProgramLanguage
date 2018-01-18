#include <stdio.h>
void main( void )
{
    int c;
    /* Create an error by writing to standard input. */
    putc( 'A', stdin );
    if( ferror( stdin ) )
    {
      perror( "Write error" );
      clearerr( stdin );
    }

    /* See if read causes an error. */
    printf( "Will input cause an error? " );
    c = getc( stdin );
    if( ferror( stdin ) )
    {
       perror( "Read error" );
       clearerr( stdin );
    }
}
