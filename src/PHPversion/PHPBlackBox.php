<?php

error_reporting(1);
require_once "BlackBox.php";

class BlackBox {
  /**
   * url
   *
   * checking if 'in' equals 'out'
   *
   * @var $val och $add_array om dessa inte får någon variabel genompasserad anges de som "false";
   * @var  mixed $array
   * @var  mixed $val
   * @var  mixed $add_array
   * @return String $get
   */
  public function url($array, $val = false, $add_array = false) {

      $customer_info = $_GET;

      //Skickar vi functionen "urldecode" med i methoden, sen blir den en String?
      $customer_info = $this->array_map_recursive("urldecode", $customer_info);

      if ($add_array) {
          $customer_info = $customer_info + $add_array;
      }

      $http = $this->is_ssl() ? "https://" : "http://";

    if(is_array($array)) {
      $indexValue = $this->iterateArray($array, $val, $customer_info);
    }
     if(isset($this->$customer_info[$array])){
         $this->buildArray($array, $val, $customer_info);
    }else{
         $val==false ? $customer_info = $customer_info + array($array => $val) : false;
    }
      return $this->complete_URL($http, $customer_info);
  }

  /**
   * iterateArray going through the 3D array and returns the value from errorCheckArray if its valid, else the value from the ternary operation.
   *
   * @var  mixed $array
   * @var  mixed $val
   * @var  mixed $customer_info
   * @return mixed
   */
  private function iterateArray($array, $val, $customer_info) {
    foreach($array as $i =>$iVal){
        if(isset($customer_info[$iVal])){
            return $this->errorCheckArray($array,$val,$i, $iVal);
        }else{
            return $val = false ?  $customer_info = $customer_info + array($iVal => $val[$i]) : null ;
          }
    }
  }

  /**
   * array_map_recursive
   *
   * iterating through the arrays, if the $array is an array = call the function again, else passes the remaining parameters as arguments.
   *
   * @var  mixed $callback = callback variabel
   * @var  mixed $array    =
   * @return Array(mixed(?)) $array
   */
  private function array_map_recursive($callback, $array) {

      foreach ($array as $key => $value) {
          if (is_array($array[$key])) {
              $array[$key] = $this->array_map_recursive($callback, $array[$key]);
          } else {
              $array[$key] = call_user_func($callback, $array[$key]);
          }
      }
      return $array;
  }
  /**
   * Setting all the values together
   */
  private function complete_URL($http, $customer_info){
    return $http . $_SERVER['HTTP_HOST'] . $_SERVER['SCRIPT_NAME'] . "?" . urldecode(http_build_query($customer_info));
}

  /**
    * buildArray
    *
    * Checking if the arrays are equal to eachother, and if they are then unset the value from $customer_info
    * and return it, and if its not equal, set and return the value of $customer_info to $val;
    *
    * @var  mixed $array
    * @var  mixed $val
    * @var  mixed $customer_info
    * @return void
    */
    private function buildArray($array, $val, $customer_info){
    if($customer_info[$array] == $val){
         //return ($customer_info[$array] == $val) ? unset($customer_info[$array]) : $customer_info[$array] = $val); too bad unset() is void.
          unset($customer_info[$array]);
          return $customer_info;
     }else{
         return $customer_info[$array] = $val;
     }
 }
  /**
   * errorCheckArray
   *
   * Checking if the array is viable for the job
   *
   * @var  mixed $array
   * @var  mixed $val   =
   * @var  mixed $i     =  index
   * @var  mixed $iVal  =  elementet på index placeringen
   * @return mixed
   */

  private function errorCheckArray($array, $val, $i, $iVal) {
    if(($val == false)
         || ($customer_info[$iVal] == $val[$i])
         || ($val[$i] == "")){
         unset($customer_info[$iVal]);
         return $customer_info;
    }else{
        return $val = false ?  $customer_info[$iVal] = $val[$i] : $customer_info[$iVal];
    }
 }
  /**
   * is_ssl
   *
   * CHecking if Secure Sockets Layer is on.
   * 443 is a standardport for ssl and majority of https users utilize this.
   *
   * @return $boolean
   */
  private function is_ssl() {
      if (isset($_SERVER['HTTPS'])) {
          if ('on' == strtolower($_SERVER['HTTPS'])) {
              return true;
          }
          if ('1' == $_SERVER['HTTPS']) {
              return true;
          }
      }
      else if (isset($_SERVER['SERVER_PORT']) && ('443' == $_SERVER['SERVER_PORT'])) {
          return true;
      }
      return false;
  }
}
/**
 * En array av arrayer av arrayer som innehåller information utifrån vilka handlingar kunden gör på hemsidan
 * An array of arrays of arrays that holds information
 */
$checks = [
  [
    '_GET' =>
      [
        'list' => 'customers',
        'page' => 2,
      ],
    'in' =>
      [
        'page',
        3,
      ],
    'out' => 'list=customers&page=3',
  ],
  [
    '_GET' =>
      [
        'list' => 'customers',
        'page' => 2,
      ],
    'in' =>
      [
        'page',
        2,
      ],
    'out' => 'list=customers',
  ],
  [
    '_GET' =>
      [
        'list' => 'customers',
        'page' => 2,
      ],
    'in' =>
      [
        [
          'list',
          'page',
        ],
        [
          'employees',
          null,
        ],
      ],
    'out' => 'list=employees',
  ],
  [
    '_GET' =>
      [
        'foo' => 1,
        'bar' => 2,
      ],
    'in' =>
      [
        'foo',
        2,
        [
          'baz' => 3,
        ],
      ],
    'out' => 'foo=2&bar=2&baz=3',
  ],
  [
    '_GET' =>
      [
        'foo' => 1,
        'bar' => 2,
      ],
    'in' =>
      [
        [
          'foo',
          'bar',
        ],
        [
          false,
          1,
        ],
      ],
    'out' => 'bar=1',
  ],
  [
    '_GET' =>
      [
        'foo' => 1,
        'bar' => 2,
      ],
    'in' =>
      [
        'baz',
      ],
    'out' => 'foo=1&bar=2',
  ],
];

$blackBox = new BlackBox();
$testsTotal = count($checks);
$testsOk = 0;

foreach ($checks as $check) {

    $_GET = $check['_GET'];
    $out = $blackBox->url(...$check['in']);
    $outParsed = parse_url($out);

    if ($outParsed['query'] === $check['out']) {
        $testsOk++;
    }
}

echo "{$testsOk} av {$testsTotal} valideringar OK\n";