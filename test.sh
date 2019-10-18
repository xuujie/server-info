while :
  do
    curl http://localhost/server
    let "i = $(($RANDOM%10))"
    echo " sleep $i seconds..."
    sleep $i
done
