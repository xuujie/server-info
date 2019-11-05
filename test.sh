while :
  do
    curl http://localhost:8080/server
    let "i = $(($RANDOM%10))"
    echo " sleep $i seconds..."
    sleep $i
done
