export const data = {
    labels: [
      '근력',
      '근지구력',
      '스피드',
      '유연성',
      '심폐지구력',
      '민첩성',
      '체지방률'
    ],
    datasets: [
      {
        label: '평균',
        backgroundColor: 'rgba(179,181,198,0.2)',
        borderColor: 'rgba(179,181,198,1)',
        pointBackgroundColor: 'rgba(179,181,198,1)',
        pointBorderColor: '#fff',
        pointHoverBackgroundColor: '#fff',
        pointHoverBorderColor: 'rgba(179,181,198,1)',
        data: [65, 59, 90, 81, 56, 55, 40]
      },
      {
        label: '나',
        backgroundColor: 'rgba(255,99,132,0.2)',
        borderColor: 'rgba(255,99,132,1)',
        pointBackgroundColor: 'rgba(255,99,132,1)',
        pointBorderColor: '#fff',
        pointHoverBackgroundColor: '#fff',
        pointHoverBorderColor: 'rgba(255,99,132,1)',
        data: [28, 48, 40, 19, 96, 27, 100]
      }
    ]
  }
  
export const options = {
    responsive: false,
    maintainAspectRatio: false,
    height: 300,
    width: 400
  }